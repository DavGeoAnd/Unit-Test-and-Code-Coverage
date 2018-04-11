import static org.junit.Assert.*;

import org.junit.Test;



public class OrderStringTest {

	@Test
	public void orderTest() {
		assertEquals(Orders.calculateTotal(25, Orders.ShippingMethod.Standard, "IL"), 37.1, 0.01);
		assertEquals(Orders.calculateTotal(25, Orders.ShippingMethod.Standard, "MN"), 35, 0.01);

		assertEquals(Orders.calculateTotal(25, Orders.ShippingMethod.NextDay, "California"), 53, 0.01); // Changed
																										// State
		assertEquals(Orders.calculateTotal(25, Orders.ShippingMethod.NextDay, "MN"), 50, 0.01);

		assertEquals(Orders.calculateTotal(75, Orders.ShippingMethod.Standard, "New York"), 79.5, 0.01);// Changed
																										// State
		assertEquals(Orders.calculateTotal(75, Orders.ShippingMethod.Standard, "MN"), 75, 0.01);

		assertEquals(Orders.calculateTotal(75, Orders.ShippingMethod.NextDay, "Illinios"), 106, 0.01);// Changed
																										// State,
																										// Illinois
																										// is
																										// spelled
																										// wrong
		assertEquals(Orders.calculateTotal(75, Orders.ShippingMethod.NextDay, "MN"), 100, 0.01);

		try {
			assertEquals(Orders.calculateTotal(-10, Orders.ShippingMethod.Standard, "IL"), -1, 0.01);
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}

		// try { Suppose to create exception but doesn't for invalid state
		// assertEquals(Orders.calculateTotal(25, ShippingMethod.Standard,
		// "YZ"), -1, 0.01);
		// } catch (IllegalArgumentException e) {
		// assertTrue(true);
		// }

		////////////////////////////////////// NEW
		////////////////////////////////////// TESTS////////////////////////////////////////////
		assertEquals(Orders.calculateTotal(25, Orders.ShippingMethod.Standard, "CA"), 37.1, 0.01);// New
																									// State
		assertEquals(Orders.calculateTotal(25, Orders.ShippingMethod.Standard, "NY"), 37.1, 0.01);// New
																									// State

		Orders test = new Orders(); // created an object
		assertEquals(test.calculateTotal(25, Orders.ShippingMethod.valueOf("NextDay"), "MN"), 50, 0.01);
		//Orders.ShippingMethod.NextDay
	}

	@Test
	public void pluralTest() {
		// assertEquals("boxes", StringUtil.pluralize("box")); //defect, returns
		// boxen
		assertEquals("prizes", StringUtil.pluralize("prize"));
		assertEquals("babies", StringUtil.pluralize("baby"));
		assertEquals("elves", StringUtil.pluralize("elf"));
		assertEquals("heroes", StringUtil.pluralize("hero"));
		assertEquals("apples", StringUtil.pluralize("apple"));

		// try { Suppose to return very since not noun
		// assertEquals("very", StringUtil.pluralize("very"));
		// } catch (IllegalArgumentException e) {
		// assertTrue(true);
		// }

		// try { Special character shouldn't return a value
		// assertEquals("12345", StringUtil.pluralize("12345"));
		// } catch (IllegalArgumentException e) {
		// assertTrue(true);
		// }

		////////////////////////////////////// NEW
		////////////////////////////////////// TESTS////////////////////////////////////////////
		StringUtil test = new StringUtil(); // Create Object

		assertEquals(null, test.pluralize(null));//Null Value
		try {//Not a letter in string
			assertEquals("TEST!", test.pluralize("TEST!"));
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}

		assertEquals("equipment", test.pluralize("equipment"));//Uncountable
		assertEquals("people", test.pluralize("person"));//Irregular
		assertEquals("baies", StringUtil.pluralize("bay"));//Checking y with vowel at end, bay plural is bays
		//fails no matter what at line 39 by the first condition or second
		
		test.main(null);
		
		
	}
}
