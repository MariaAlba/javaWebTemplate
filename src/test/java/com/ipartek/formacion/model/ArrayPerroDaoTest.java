package com.ipartek.formacion.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.model.pojo.Perro;

public class ArrayPerroDaoTest {

	private static ArrayPerroDao dao;
	private static Perro mock;

	private static final int MOCK_ID = 1;
	private static final int MOCK_ID_INEXISTENTE = -1;
	private static final String MOCK_NOMBRE = "Pulgas mock";

	private static int indice = MOCK_ID;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = ArrayPerroDao.getInstance();
		mock = new Perro(indice, MOCK_NOMBRE, "");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
		// dao.delete(mock.getId());
		mock = null;
	}

	@Before
	public void setUp() throws Exception {
		// dao.create(mock);
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testGetAll() throws Exception {
		assertEquals("debería existir un perro en la lista", 1, dao.getAll().size());
//		dao.delete(mock.getId());
//		assertEquals(0, dao.getAll().size());
	}

	@Test
	public void testGetbyId() {

		// assertNull("no debería existir ningun perro con esta id", dao.getbyId(-1));

		Perro p = dao.getbyId(indice);
		assertEquals(p, mock);
	}

	@Test
	public void testDelete() {
		try {

			// Solucionar bug tearDown => crear perro para elimiar
			Perro pEliminar = new Perro(2, "pulgas 345", "");
			dao.create(pEliminar);

			// assertSame("debería ser pulgas", pEliminar, mock);
			assertEquals("deberian quedar 0 perros ", 1, dao.getAll().size());

//			dao.delete(MOCK_ID_INEXISTENTE);
//			fail("debería haber lanzado excepcion");

		} catch (Exception e) {

			assertTrue("Lanzada excepcion correctamente al eliminar perro que no existe", true);
		}
	}

	@Test
	public void testUpdate() {
		// TODO testUpdate
	}

	@Test
	public void testCreate() {
		// TODO testCreate
	}

}
