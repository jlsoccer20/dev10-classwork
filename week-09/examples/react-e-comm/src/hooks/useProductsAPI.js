import { useState, useEffect } from 'react';

export default function useProductsAPI() {
	const [products, setProducts] = useState([]);

	useEffect(() => {
		fetch('https://dummyjson.com/products/category/laptops')
			.then(res => res.json())
			.then(data => setProducts(data.products))
			.catch(err => {
				console.error(err);
			});
	}, []);

	return products;
}
