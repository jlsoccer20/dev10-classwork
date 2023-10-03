export default function Header({ toggleCart }) {
	return (
		<header>
			<h1>Dev10 eComm Store</h1>
			<nav>
				<button onClick={toggleCart}>
					<img
						width='30'
						alt='Shopping cart'
						src='https://www.freepnglogos.com/uploads/shopping-cart-png/shopping-cart-svg-png-icon-download-28.png'
					/>
				</button>
			</nav>
		</header>
	);
}
