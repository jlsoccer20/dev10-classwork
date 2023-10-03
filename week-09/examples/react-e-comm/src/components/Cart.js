import CartInfo from './CartInfo';
import ProductCard from './ProductCard';

export default function Cart({
	cartItems,
	cartOpen,
	changeQuantity,
	removeProductFromCart,
	toggleCart,
}) {
	return (
		<div className={`cart ${cartOpen ? 'open' : 'closed'}`}>
			<div className='cart-header'>
				<h2>Your Cart</h2>
				<button className='btn' onClick={toggleCart}>
					Close
				</button>
			</div>
			<CartInfo cartItems={cartItems} />
			{cartItems.length ? (
				cartItems.map(product => (
					<ProductCard
						addToCart={removeProductFromCart}
						cartView={true}
						changeQuantity={changeQuantity}
						key={product.id}
						product={product}
					/>
				))
			) : (
				<div>Nothing here yet!</div>
			)}
		</div>
	);
}
