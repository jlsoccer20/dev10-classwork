import {Link} from 'react-router-dom';

import Button from './Button';

export default function SolarPanelForm() {
	return (
		<>
			<h1>Add Solar Panel</h1>
			<form>
				<div>
					<Button classes='btn-primary me-2' type='submit'>
						Submit
					</Button>
					<Link className='btn btn-secondary' to='/solarpanels'>
                        Cancel
                    </Link>
				</div>
			</form>
		</>
	);
}
