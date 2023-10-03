import EditLink from './EditLink';
import DeleteLink from './DeleteLink';

function AgentRow({ agent }) {
	return (
		<tr>
			<td>
				{agent.firstName} {agent.middleName} {agent.lastName}
			</td>
			<td>{agent.dob ?? 'Unknown'}</td>
			<td>{agent.heightInInches}</td>
			<td>
				<EditLink path={`/agents/edit/${agent.agentId}`} />
				<DeleteLink path={`/agents/delete/${agent.agentId}`} />
			</td>
		</tr>
	);
}

export default AgentRow;
