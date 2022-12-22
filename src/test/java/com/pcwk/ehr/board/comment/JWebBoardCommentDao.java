package com.pcwk.ehr.board.comment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pcwk.ehr.board.comment.dao.BoardCommentDao;
import com.pcwk.ehr.board.comment.domain.BoardCommentVO;
import com.pcwk.ehr.board.cmn.SearchVO;

@RunWith(SpringJUnit4ClassRunner.class) // spring-test lib에 있음!
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class JWebBoardCommentDao {
	final Logger LOG = LogManager.getLogger(getClass());

	@Autowired
	BoardCommentDao dao;

	BoardCommentVO boardCommentVO1;

	SearchVO searchVO;

	@Before
	public void setUp() throws Exception {

		boardCommentVO1 = new BoardCommentVO(99999999, 1, 2, 3, "contents", "사용X");

	}

	@Test
	public void doRetrieve() throws Exception {
		List<BoardCommentVO> list = dao.doRetrieve(searchVO);
	}

	@Test
	@Ignore
	public void doUpdate() throws Exception {
		boardCommentVO1.setCmSeq(1000002);
		boardCommentVO1.setContents("ㅋㅋㅄ");

		dao.doUpdate(boardCommentVO1);

	}

	@Test
	@Ignore
	public void doDelete() throws Exception {
		boardCommentVO1.setCmSeq(1000001);
		int flag = dao.doDelete(boardCommentVO1);

	}

	@Test
	@Ignore
	public void doSave() throws Exception {
		LOG.debug("doSave");
		dao.doSave(boardCommentVO1);

	}

	@Test
	public void bean() {
		assertNotNull(dao);
	}

}
