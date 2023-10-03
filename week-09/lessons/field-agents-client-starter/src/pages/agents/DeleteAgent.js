import { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

import CancelLink from '../../components/CancelLink';
import { deleteAgentById, findAgentById } from '../../services/agents';

function AgentDeleteConfirm() {
	const [agent, setAgent] = useState(null);
	const navigate = useNavigate();
	const { agentId } = useParams();

	function handleDelete(event) {
		deleteAgentById(agentId)
			.then(() => navigate('/agents'))
			.catch(error => {
				console.error(error);
				navigate(`/error`, { state: { error } });
			});
	}

	useEffect(() => {
		if (agentId) {
			findAgentById(agentId)
				.then(setAgent)
				.catch(error => {
					console.error(error);
					navigate(`/error`, { state: { error } });
				});
		}
	}, [agentId]);

	if (!agent) return null;

	return (
		<>
			<h1>Delete Confirm</h1>
			<div className='alert alert-warning' role='alert'>
				<p>Are you sure you want to delete the following agent?</p>
				<ul>
					<li>
						Name: {agent.firstName} {agent.middleName}{' '}
						{agent.lastName}
					</li>
					<li>Date of Birth: {agent.dob ?? 'Unknown'}</li>
					<li>Height : {agent.heightInInches} inches</li>
				</ul>
				<div>
					<button
						onClick={handleDelete}
						className='btn btn-danger me-2'>
						Delete
					</button>
					<CancelLink path='/agents' />
				</div>
			</div>
		</>
	);
}

export default AgentDeleteConfirm;
