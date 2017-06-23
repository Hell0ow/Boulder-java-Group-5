/**
 * 
 */
package controller.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Imodel.IModel;
import Iview.IView;
import controller.ControllerDAO;
import controller.ControllerDB;
import controller.Factory;
import model.Model;
import state.PreGamestate;
import view.Frame;
import view.KeyManager;
import view.View;

/**
 * @author antoi
 *
 */
public class ControllerTest {
	
	
	private IModel model;
	private IView view;
	private String MapName;
	private String PlayerName;
	private int MapID;
	private int testINT;
	private IView viewTEST = Factory.createView(model);
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		PlayerName = new String();
		MapName = new String();
		MapID = 0;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link controller.Controller#Controller()}.
	 */
	@Test
	public void testController() {
		try {
			model = Factory.createModel();
			assertEquals(model.getClass(), new Model().getClass());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link controller.Controller#getModel()}.
	 */
	@Test
	public void testGetModel() {
		try {
			assertEquals(model.getClass(), new Model().getClass());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link controller.Controller#getView()}.
	 * @throws Exception 
	 */
	@Test
	public void testGetView() throws Exception {
		assertEquals(viewTEST.getClass(), new View(model).getClass());
	}

	/**
	 * Test method for {@link controller.Controller#initGame()}.
	 * @throws Exception 
	 */
	@Test
	public void testInitGame() throws Exception {
		ControllerDB database = Factory.createControllerDB();
		assertEquals(database.getClass(), new ControllerDB("java", "bigouneroot").getClass());
		
		MapName = PreGamestate.getMapName();
		assertEquals(MapName.getClass(), new String().getClass());
		
		PlayerName = PreGamestate.getPlayerName();
		assertEquals(MapName.getClass(), new String().getClass());
		
		MapID = ControllerDAO.getIDmap(database, MapName);
		assertEquals(MapID, 4);
	}

	/**
	 * Test method for {@link controller.Controller#Game()}.
	 * @throws Exception 
	 */
	@Test
	public void testGame() throws Exception {
		view = Factory.createView(model);
		assertEquals(view.getClass(), new View(model).getClass());
		
		KeyManager keyEvent = ((Frame) view.getFrame()).getKeyManager();
		assertEquals(keyEvent.getClass(), new KeyManager().getClass());
	}

}
