import { Link } from 'react-router-dom';

function DeleteLink({ path }) {
	return (
		<Link to={path} className='btn btn-danger me-2'>
			Delete <i className='bi bi-trash'></i>
		</Link>
	);
}

export default DeleteLink;
