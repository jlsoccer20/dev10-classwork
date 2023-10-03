import { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

import CancelLink from '../../components/CancelLink';
import FormErrors from '../../components/FormErrors';
import SubmitButton from '../../components/SubmitButton';
import { findAgentById, saveAgent } from '../../services/agents';

const initialAgent = {
	agentId: 0,
	firstName: '',
	lastName: '',
	middleName: '',
	heightInInches: 0,
	dob: '',
	aliases: [],
};

function AgentForm() {
	const [agent, setAgent] = useState(initialAgent);
	const [errors, setErrors] = useState([]);
	const { agentId } = useParams();
	const navigate = useNavigate();

	function handleChange(event) {
		setAgent({ ...agent, [event.target.name]: event.target.value });
	}

	function handleSubmit(event) {
		event.preventDefault();
		saveAgent(agent)
			.then(res => {
				if (!res) {
					navigate('/agents');
				} else {
					if (res.error) {
						setErrors([res.error]);
					} else {
						setErrors(res);
					}
				}
			})
			.catch(error => {
				console.error(error);
				navigate('/error', { state: { error } });
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

	return (
		<>
			<h1>{agentId > 0 ? 'Update' : 'Add'} Agent</h1>
			<FormErrors errors={errors} />
			<form onSubmit={handleSubmit}>
				<div className='mb-3'>
					<label htmlFor='firstName' className='form-label'>
						First Name
					</label>
					<input
						type='text'
						className='form-control'
						id='firstName'
						name='firstName'
						onChange={handleChange}
						value={agent.firstName}
					/>
				</div>
				<div className='mb-3'>
					<label htmlFor='middleName' className='form-label'>
						Middle Name
					</label>
					<input
						type='text'
						className='form-control'
						id='middleName'
						name='middleName'
						onChange={handleChange}
						value={agent.middleName}
					/>
				</div>
				<div className='mb-3'>
					<label htmlFor='lastName' className='form-label'>
						Last Name
					</label>
					<input
						type='text'
						className='form-control'
						id='lastName'
						name='lastName'
						onChange={handleChange}
						value={agent.lastName}
					/>
				</div>
				<div className='mb-3'>
					<label htmlFor='heightInInches' className='form-label'>
						Height (Inches)
					</label>
					<input
						type='number'
						className='form-control'
						id='heightInInches'
						name='heightInInches'
						onChange={handleChange}
						value={agent.heightInInches}
					/>
				</div>
				<div className='mb-3'>
					<label htmlFor='dob' className='form-label'>
						Date of Birth
					</label>
					<input
						type='date'
						className='form-control'
						id='dob'
						name='dob'
						onChange={handleChange}
						value={agent.dob ?? ''}
					/>
				</div>
				<div className='mb-3'>
					<SubmitButton />
					<CancelLink path='/agents' />
				</div>
			</form>
		</>
	);
}

export default AgentForm;
