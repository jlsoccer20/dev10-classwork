function CharacterCard({ character }) {
	return (
		<div className='col'>
			<div className='card h-100'>
				<div className='card-header'>
					<h4 className='card-title'>{character.name}</h4>
				</div>
				<div className='card-body'>
					<ul>
						<li>Race: {character.race || 'Unknown'}</li>
						<li>Born: {character.birth || 'Unknown'}</li>
						<li>Death: {character.death || 'Unknown '}</li>
						<li>Gender: {character.gender || 'Unknown'}</li>
						<li>Hair: {character.hair || 'Unknown'}</li>
					</ul>
				</div>
				<div className='card-footer'>
					<small>
						{character.wikiUrl ? (
							<a
								target='_blank'
								rel='noreferrer noopener'
								href={character.wikiUrl}>
								Wiki Link
							</a>
						) : (
							<>Link Unavailable</>
						)}
					</small>
				</div>
			</div>
		</div>
	);
}

export default CharacterCard;
