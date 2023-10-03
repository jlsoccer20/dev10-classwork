import { useState } from 'react';

function CharacterSearch({ handleSearch }) {
	const [searchString, setSearchString] = useState('');

	return (
		<form
			className='mb-3'
			onSubmit={e => {
				e.preventDefault();
				handleSearch(searchString.trim());
				setSearchString('');
			}}>
			<div className='mb-3'>
				<label className='form-label' htmlFor='searchString'>
					Search by Character Name
				</label>
				<input
					required
					className='form-control'
					type='text'
					id='searchString'
					placeholder='E.g., Baggins'
					name='searchString'
					value={searchString}
					onChange={e => setSearchString(e.target.value)}
				/>
			</div>
			<button type='submit' className='btn btn-primary'>
				Submit
			</button>
		</form>
	);
}

export default CharacterSearch;
