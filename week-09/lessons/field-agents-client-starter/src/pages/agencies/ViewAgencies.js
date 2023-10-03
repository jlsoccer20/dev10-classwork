import { useEffect, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';

import AgencyRow from '../../components/AgencyRow';
import { findAllAgencies } from '../../services/agencies';
import TableHead from '../../components/TableHead';

function ViewAgencies() {
	const [agencies, setAgencies] = useState([]);
	const navigate = useNavigate();

	useEffect(() => {
		findAllAgencies()
			.then(setAgencies)
			.catch(error => {
				console.error(error);
				navigate('/error', { state: { error } });
			});
	}, []);

	return (
		<>
			<h1>Agencies</h1>

			<Link className='btn btn-primary mb-3' to='/agencies/add'>
				Add Agency <i className='bi bi-plus-circle-fill'></i>
			</Link>

			<table className='table table-striped table-hover'>
				<TableHead headers={['Abbreviation', 'Name', <>&nbsp;</>]} />
				<tbody>
					{agencies.map(agency => (
						<AgencyRow agency={agency} key={agency.agencyId} />
					))}
				</tbody>
			</table>
		</>
	);
}

export default ViewAgencies;
