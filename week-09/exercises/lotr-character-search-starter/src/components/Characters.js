import { useReducer, useState } from 'react';

import CharacterCard from './CharacterCard';
import CharacterSearch from './CharacterSearch';
import Loading from './Loading';

// Action object
// {
// 	type: 'error',
// 	payload: []
// }

function searchReducer(state, action) {
	switch (action.type) {
		case 'loading':
			return { results: [], loading: true, error: '' };
		case 'error':
			return {
				...state,
				loading: false,
				error: action.payload,
			};
		case 'success':
			return {
				...state,
				loading: false,
				results: action.payload,
			};
		default:
			throw new Error(`Unexpected action type ${action.type}`);
	}
}

function Characters() {
	const [state, dispatch] = useReducer(searchReducer, {
		loading: false,
		error: '',
		results: [],
	});
	const { loading, error, results } = state;

	function handleSearch(searchString) {
		dispatch({ type: 'loading' });

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
					dispatch({ type: 'success', payload: data.docs });
				} else {
					dispatch({
						type: 'error',
						payload: `No results found for "${searchString}". Try another search.`,
					});
				}
			})
			.catch(err => {
				console.log(err);
				dispatch({
					type: 'error',
					payload: err.message ?? 'Unknown error',
				});
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
