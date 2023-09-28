import Button from './Button';

export default function SolarPanelForm({ toggleView }) {
	return (
		<>
			<h1>Add Solar Panel</h1>
			<form>
				<div>
					<Button classes='btn-primary' type='submit'>
						Submit
					</Button>
					<Button
						classes='btn-secondary'
						type='button'
						handleClick={() => toggleView('list')}>
						Cancel
					</Button>
				</div>
			</form>
		</>
	);
}
