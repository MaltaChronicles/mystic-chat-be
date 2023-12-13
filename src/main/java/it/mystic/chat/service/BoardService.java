package it.mystic.chat.service;

import it.mystic.chat.mapper.BoardMapper;
import it.mystic.chat.model.dao.BoardAnswerDao;
import it.mystic.chat.model.dao.BoardDao;
import it.mystic.chat.model.dao.BoardDiscussionDao;
import it.mystic.chat.model.dto.board.Board;
import it.mystic.chat.model.dto.board.BoardAnswer;
import it.mystic.chat.model.dto.board.BoardDiscussion;
import it.mystic.chat.model.dto.player.Player;
import it.mystic.chat.model.dto.pk.BoardDiscussionPk;
import it.mystic.chat.model.enums.BoardType;
import it.mystic.chat.model.response.board.BoardAnswerResponse;
import it.mystic.chat.model.response.board.BoardDiscussionResponse;
import it.mystic.chat.model.response.board.BoardResponse;
import it.mystic.chat.repo.board.BoardAnswerRepo;
import it.mystic.chat.repo.board.BoardDiscussionRepo;
import it.mystic.chat.repo.board.BoardRepo;
import it.mystic.chat.repo.player.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BoardService {
    @Autowired
    private BoardRepo boardRepo;
    @Autowired
    private BoardDiscussionRepo boardDiscussionRepo;
    @Autowired
    private BoardAnswerRepo boardAnswerRepo;
    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private BoardMapper boardMapper;

    public BoardResponse create(BoardDao boardDao) {
        Board board =  boardMapper.daoToDto(boardDao);
        return boardMapper.dtoToResponse(boardRepo.save(board));
    }

    public void update(Long boardId, BoardDao boardDao) {
        Board board = boardRepo.getReferenceById(boardId);
        board.setTitle(boardDao.title());
        board.setBody(boardDao.body());
        boardRepo.save(board);
    }

    public List<BoardResponse> getBoardsByType(BoardType type) {
        return boardMapper.dtoListToResponseList(boardRepo.getByType(type));
    }

    public List<BoardDiscussionResponse> getDiscussionByBoardId(Long boardId) {
        List<BoardDiscussion> boardDiscussions = boardRepo.getReferenceById(boardId).getDiscussions();
        return boardMapper.discussionListToResponseList(boardDiscussions);
    }

    public void delete(Long boardId) {
        boardRepo.deleteById(boardId);
    }

    public BoardDiscussionResponse addDiscussion(Long boardId, Long playerId, BoardDiscussionDao boardDiscussionDao) {
        Board board = boardRepo.getReferenceById(boardId);
        Player player = playerRepo.getReferenceById(playerId);
        BoardDiscussion boardDiscussion = boardMapper.discussionDaoToDto(board, player, boardDiscussionDao);
        return boardMapper.discussionDtoToResponse(boardDiscussionRepo.save(boardDiscussion));
    }

    private BoardDiscussion getDiscussion(Long boardId, Long playerId, UUID uuid){
        Board board = boardRepo.getReferenceById(boardId);
        Player player = playerRepo.getReferenceById(playerId);
        return boardDiscussionRepo.getReferenceById(new BoardDiscussionPk(board, player, uuid.toString()));
    }

    public List<BoardAnswerResponse> openDiscussion(Long boardId, Long playerId, UUID uuid) {
        BoardDiscussion boardDiscussion = getDiscussion(boardId, playerId, uuid);
        return boardMapper.answerListToResponseList(boardDiscussion.getAnswers());
    }

    public void changeIsOpen(Long boardId, Long playerId, UUID uuid) {
        BoardDiscussion boardDiscussion =  getDiscussion(boardId, playerId, uuid);
        boardDiscussion.setIsOpen(!boardDiscussion.getIsOpen());
        boardDiscussionRepo.save(boardDiscussion);
    }

    public void changeIsPin(Long boardId, Long playerId, UUID uuid) {
        BoardDiscussion boardDiscussion =  getDiscussion(boardId, playerId, uuid);
        boardDiscussion.setIsPin(!boardDiscussion.getIsPin());
        boardDiscussionRepo.save(boardDiscussion);
    }

    public BoardAnswerResponse createAnswer(Long boardId, Long openPlayerId, UUID uuid, BoardAnswerDao boardAnswerDao) {
        BoardDiscussion boardDiscussion =  getDiscussion(boardId, openPlayerId, uuid);
        Player player = playerRepo.getReferenceById(boardAnswerDao.playerId());
        BoardAnswer boardAnswer = boardMapper.answerDaoToDto(boardDiscussion, player, boardAnswerDao);
        return boardMapper.answerDtoToResponse(boardAnswerRepo.save(boardAnswer));
    }
}
