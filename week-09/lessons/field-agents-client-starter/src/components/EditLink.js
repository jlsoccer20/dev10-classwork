import { Link } from 'react-router-dom';

function EditLink({ path }) {
	return (
		<Link to={path} className='btn btn-info me-2'>
			Edit <i className='bi bi-pencil-square'></i>
		</Link>
	);
}

export default EditLink;
