import { useEffect, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';

import AgentRow from '../../components/AgentRow';
import TableHead from '../../components/TableHead';
import { findAllAgents } from '../../services/agents';

function AgentsTable() {
	const [agents, setAgents] = useState([]);
	const navigate = useNavigate();

	useEffect(() => {
		findAllAgents()
			.then(setAgents)
			.catch(error => {
				console.log(error);
				navigate('/error', { state: { error } });
			});
	}, []);

	return (
		<>
			<h1>Agents</h1>
			<Link to='/agents/add' className='btn btn-primary mb-3'>
				Add Agent <i className='bi bi-person-plus-fill'></i>
			</Link>
			<table className='table table-striped table-hover'>
				<TableHead
					headers={['Name', 'DOB', 'Height (inches)', 'Modify']}
				/>
				<tbody>
					{agents.map(agent => (
						<AgentRow agent={agent} key={agent.agentId} />
					))}
				</tbody>
			</table>
		</>
	);
}

export default AgentsTable;
