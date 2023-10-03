import ProductCard from './ProductCard';
import useProductsAPI from '../hooks/useProductsAPI';

export default function Products({ addToCart }) {
	const products = useProductsAPI();

	return (
		<div className='cards-wrapper'>
			{products.length > 0 ? (
				products.map(product => (
					<ProductCard
						key={product.id}
						product={product}
						addToCart={addToCart}
					/>
				))
			) : (
				<div>Loading...</div>
			)}
		</div>
	);
}
