export default function ProductCard({
	addToCart,
	cartView,
	changeQuantity,
	product,
}) {
	return (
		<div className='card'>
			<img
				style={{ height: '250px', objectFit: 'cover' }}
				src={`${product.images[0]}`}
				alt={product.title}
			/>
			<div className='description'>
				<h2>{product.title}</h2>
				<div className='price'>{`$${product.price}`}</div>
			</div>
			{cartView && (
				<div className='quantity'>
					<button
						className='quantity-decrease'
						onClick={() =>
							changeQuantity(product, product.quantity - 1)
						}>
						-
					</button>
					Quantity: {product.quantity ?? 1}
					<button
						className='quantity-increase'
						onClick={() =>
							changeQuantity(product, product.quantity + 1)
						}>
						+
					</button>
				</div>
			)}
			{addToCart && (
				<button
					className='btn btn-primary'
					onClick={() => addToCart(product)}>
					{cartView ? 'Remove from Cart' : 'Add to Cart'}
				</button>
			)}
		</div>
	);
}
