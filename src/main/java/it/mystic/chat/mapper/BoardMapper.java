package it.mystic.chat.mapper;

import it.mystic.chat.model.dao.BoardAnswerDao;
import it.mystic.chat.model.dao.BoardDao;
import it.mystic.chat.model.dao.BoardDiscussionDao;
import it.mystic.chat.model.dto.board.Board;
import it.mystic.chat.model.dto.board.BoardAnswer;
import it.mystic.chat.model.dto.board.BoardDiscussion;
import it.mystic.chat.model.dto.player.Player;
import it.mystic.chat.model.dto.pk.BoardAnswerPk;
import it.mystic.chat.model.dto.pk.BoardDiscussionPk;
import it.mystic.chat.model.response.board.BoardAnswerResponse;
import it.mystic.chat.model.response.board.BoardDiscussionResponse;
import it.mystic.chat.model.response.board.BoardResponse;
import it.mystic.chat.model.response.id.BoardAnswerIdResponse;
import it.mystic.chat.model.response.id.BoardDiscussionIdResponse;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Component
public class BoardMapper {
    public Board daoToDto(BoardDao boardDao) {
        if(Objects.isNull(boardDao))
            return null;
        return new Board(
                null,
                boardDao.type(),
                boardDao.title(),
                boardDao.body(),
                null
        );
    }

    public BoardResponse dtoToResponse(Board board) {
        if(Objects.isNull(board))
            return null;
        return new BoardResponse(
                board.getBoardId(),
                board.getTitle(),
                board.getBody()
        );
    }

    public List<BoardResponse> dtoListToResponseList(List<Board> boardList) {
        if(Objects.isNull(boardList))
            return null;
        return boardList.stream().map(this::dtoToResponse).toList();
    }

    public List<BoardDiscussionResponse> discussionListToResponseList(List<BoardDiscussion> discussionList) {
        if(Objects.isNull(discussionList))
            return null;
        return discussionList.stream().map(this::discussionDtoToResponse).toList();
    }

    public BoardDiscussion discussionDaoToDto(Board board, Player player, BoardDiscussionDao boardDiscussionDao) {
        if(Objects.isNull(board) || Objects.isNull(player) || Objects.isNull(boardDiscussionDao))
            return null;
        return new BoardDiscussion(
                new BoardDiscussionPk(board, player, UUID.randomUUID().toString()),
                boardDiscussionDao.title(),
                new Date(),
                boardDiscussionDao.body(),
                true,
                false,
                null
        );
    }

    private BoardDiscussionIdResponse discussionPkToIdResponse(BoardDiscussionPk pk){
        if(Objects.isNull(pk))
            return null;
        return new BoardDiscussionIdResponse(
                pk.getBoard().getBoardId(),
                pk.getOpenBy().getPlayerId(),
                pk.getDiscussionUuid()
        );
    }

    public BoardDiscussionResponse discussionDtoToResponse(BoardDiscussion boardDiscussion) {
        if(Objects.isNull(boardDiscussion))
            return null;
        return new BoardDiscussionResponse(
                discussionPkToIdResponse(boardDiscussion.getId()),
                boardDiscussion.getTitle(),
                boardDiscussion.getBody(),
                boardDiscussion.getIsOpen(),
                boardDiscussion.getIsPin(),
                boardDiscussion.getOpenDate()
        );
    }

    public List<BoardAnswerResponse> answerListToResponseList(List<BoardAnswer> answerList) {
        if(Objects.isNull(answerList))
            return null;
        return answerList.stream().map(this::answerDtoToResponse).toList();
    }

    public BoardAnswer answerDaoToDto(BoardDiscussion boardDiscussion, Player player, BoardAnswerDao boardAnswerDao) {
        if(Objects.isNull(boardDiscussion) || Objects.isNull(boardAnswerDao))
            return null;
        return new BoardAnswer(
                new BoardAnswerPk(
                        boardDiscussion,
                        player,
                        UUID.randomUUID().toString()
                ),
                boardAnswerDao.body(),
                new Date()
        );
    }

    public BoardAnswerResponse answerDtoToResponse(BoardAnswer boardAnswer) {
        if(Objects.isNull(boardAnswer))
            return null;
        return new BoardAnswerResponse(
                new BoardAnswerIdResponse(
                        boardAnswer.getId().getWrittenBy().getPlayerId(),
                        boardAnswer.getId().getAnswerUuid()
                ),
                boardAnswer.getBody(),
                boardAnswer.getAnswerDate()
        );
    }
}
