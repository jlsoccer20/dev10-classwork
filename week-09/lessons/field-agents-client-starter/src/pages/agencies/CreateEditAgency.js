import { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

import FormErrors from '../../components/FormErrors';
import { findAgencyById, saveAgency } from '../../services/agencies';
import SubmitButton from '../../components/SubmitButton';
import CancelLink from '../../components/CancelLink';

const initialAgency = {
	agencyId: 0,
	shortName: '',
	longName: '',
	agents: [],
	locations: [],
};

function AgencyForm() {
	const [agency, setAgency] = useState(initialAgency);
	const [errors, setErrors] = useState([]);
	const { agencyId } = useParams();
	const navigate = useNavigate();

	function handleSubmit(event) {
		event.preventDefault();
		saveAgency(agency)
			.then(res => {
				if (!res) {
					navigate('/agencies');
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
				navigate('/error', { state: error });
			});
	}

	function handleChange(event) {
		setAgency({ ...agency, [event.target.name]: event.target.value });
	}

	useEffect(() => {
		if (agencyId) {
			findAgencyById(agencyId)
				.then(setAgency)
				.catch(error => {
					console.error(error);
					navigate('/error', { state: error });
				});
		}
	}, [agencyId]);

	return (
		<>
			<h1>{agencyId > 0 ? 'Update' : 'Add'} Agency</h1>
			<form onSubmit={handleSubmit}>
				<div className='mb-3'>
					<label htmlFor='shortName' className='form-label'>
						Abbreviation
					</label>
					<input
						type='text'
						className='form-control'
						id='shortName'
						name='shortName'
						onChange={handleChange}
						value={agency.shortName}
					/>
				</div>
				<div className='mb-3'>
					<label htmlFor='longName' className='form-label'>
						Full Name
					</label>
					<input
						type='text'
						className='form-control'
						id='longName'
						name='longName'
						onChange={handleChange}
						value={agency.longName}
					/>
				</div>
				<div className='mb-3'>
					<SubmitButton />
					<CancelLink path='/agencies' />
				</div>
			</form>
			<FormErrors errors={errors} />
		</>
	);
}

export default AgencyForm;
