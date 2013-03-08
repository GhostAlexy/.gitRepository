/**
 * 
 */
package controller.date.display.categoryProduct;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 * @author GhostAlexy
 * 
 */
public class ListProductCategoryTest {

	private ListProductCategoryExtractor productCateg;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		productCateg = new ListProductCategoryExtractor();
	}

	/**
	 * Test method for
	 * {@link controller.date.display.categoryProduct.ListProductCategoryExtractor#getAllProductsCategoryElements()}
	 * .
	 */
	@Test
	public void testGetAllProductsCategoryElements() {
		ArrayList<ProductCategory> list = new ArrayList<ProductCategory>();
		list.addAll(productCateg.getAllProductsCategoryElements());
		int expectedNumberOfInreg = 7;
		assertEquals(expectedNumberOfInreg, list.size());
	}

	/**
	 * Test method for
	 * {@link controller.date.display.categoryProduct.ListProductCategoryExtractor#getProductsCategoryGrouped(int, int, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testGetProductsCategoryGrouped() {
		ArrayList<ProductCategory> list = new ArrayList<ProductCategory>();
		list.addAll(productCateg.getOneProductCategoryElement("4"));
		int expectedNumberOfInreg = 1;
		// System.out.println("Error Method return is incorrect!! Please check the implementation and try to fix the error before to restart the test!!");
		assertEquals(expectedNumberOfInreg, list.size());
	}

	//
	// /**
	// * Test method for
	// * {@link
	// controller.date.display.categoryProduct.ListProductCategoryExtractor#getNoOfRecords()}
	// * .
	// */
	// @Test
	// public void testGetNoOfRecords() {
	// fail("Not yet implemented");
	// }
	//
	// /**
	// * Test method for
	// * {@link
	// controller.date.display.categoryProduct.ListProductCategoryExtractor#getOneProductCategoryElement(java.lang.String)}
	// * .
	// */
	// @Test
	// public void testGetOneProductCategoryElement() {
	// fail("Not yet implemented");
	// }

}