export default function CartInfo({ cartItems }) {
	function renderTotal() {
		const total = cartItems.reduce((acc, item) => {
			if (item.quantity) {
				return acc + item.quantity * item.price;
			}
			return acc + item.price;
		}, 0);
		return new Intl.NumberFormat('en-US', {
			style: 'currency',
			currency: 'USD',
		}).format(total);
	}

	function renderTotalItems() {
		return cartItems.reduce((acc, item) => {
			if (item.quantity) {
				return acc + item.quantity;
			}
			return acc + 1;
		}, 0);
	}

	return (
		<div>
			<p>Total Items: {renderTotalItems()}</p>
			<p>Subtotal: {renderTotal()}</p>
		</div>
	);
}
