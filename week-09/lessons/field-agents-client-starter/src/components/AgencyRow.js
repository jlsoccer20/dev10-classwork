import { Link } from 'react-router-dom';
import EditLink from './EditLink';

function AgencyRow({ agency }) {
	return (
		<tr>
			<td>{agency.shortName}</td>
			<td>{agency.longName}</td>
			<td>
				<Link
					to={`/agencies/${agency.agencyId}`}
					className='btn btn-success me-2'>
					Details <i className='bi bi-zoom-in'></i>
				</Link>
				<EditLink path={`/agencies/edit/${agency.agencyId}`} />
			</td>
		</tr>
	);
}

export default AgencyRow;
