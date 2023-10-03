import { useState } from 'react';

import Header from './components/Header';
import Cart from './components/Cart';
import Products from './components/Products';
import useDisableBodyScroll from './hooks/useDisableBodyScroll';

import './App.css';

export default function App() {
	const [cartOpen, setCartOpen] = useState(false);
	const [cartItems, setCartItems] = useState([]);
	// Disable body scroll on cart menu open
	useDisableBodyScroll(cartOpen);

	function toggleCart() {
		setCartOpen(!cartOpen);
	}

	function addToCart(item) {
		toggleCart();
	}

	function removeProductFromCart(item) {}

	function changeQuantity(item, quantity) {}

	return (
		<>
			<div className={cartOpen ? 'overlay' : ''}></div>

			<Header toggleCart={toggleCart} />
			<main>
				<Cart
					cartOpen={cartOpen}
					toggleCart={toggleCart}
					cartItems={cartItems}
					removeProductFromCart={removeProductFromCart}
					changeQuantity={changeQuantity}
				/>
				<Products addToCart={addToCart} />
			</main>
		</>
	);
}
