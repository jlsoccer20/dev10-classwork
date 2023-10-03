import { useState } from 'react';

import CharacterCard from './CharacterCard';
import CharacterSearch from './CharacterSearch';
import Loading from './Loading';

function Characters() {
	const [loading, setLoading] = useState(false);
	const [error, setError] = useState('');
	const [results, setResults] = useState([]);


	function handleSearch(searchString) {
		setError('');
		setLoading(true);
		setResults([]);

		const init = {
			headers: {
				Accept: 'application/json',
				Authorization: `Bearer ${process.env.REACT_APP_LOTR_API_KEY}`,
			},
		};

		fetch(
			`https://the-one-api.dev/v2/character?name=/${searchString}/i`,
			init
		)
			.then(res => {
				if (res.ok) {
					return res.json();
				} else {
					return Promise.reject(
						new Error(`Unexpected status code: ${res.status}`)
					);
				}
			})
			.then(data => {
				if (data.docs.length) {
					setResults(data.docs);
				} else {
					setError(
					`No results found for "${searchString}". Try another search.`,
					);
				}
				setLoading(false);
			})
			.catch(err => {
				console.log(err);
				setError(err.message ?? 'Unknown error');
				setLoading(false);
				setResults([])
			});
	}

	return (
		<main>
			<CharacterSearch handleSearch={handleSearch} />
			{loading && <Loading />}
			{error && <p>{error}</p>}
			{!!results.length && (
				<>
					<h3>Search Results:</h3>
					<div className='row row-cols-1 row-cols-md-3 g-4'>
						{results.map(character => (
							<CharacterCard
								key={character._id}
								character={character}
							/>
						))}
					</div>
				</>
			)}
		</main>
	);
}

export default Characters;
