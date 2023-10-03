import { Link } from 'react-router-dom';

function CancelLink({ path }) {
	return (
		<Link to={path} className='btn btn-secondary'>
			Cancel
		</Link>
	);
}

export default CancelLink;
