import { useState } from 'react';

function Counter() {
	const [count, setCount] = useState(0);

	function handleIncrement() {
		setCount(count + 1);
	}

	function handleDecrement() {
		setCount(count - 1);
	}

	function handleReset() {
		setCount(0);
	}

	return (
		<div>
			<h2>{count}</h2>
			<div>
				<button onClick={handleIncrement}>+</button>
				<button onClick={handleDecrement}>-</button>
				<button onClick={handleReset}>Reset</button>
			</div>
		</div>
	);
}

export default Counter;
