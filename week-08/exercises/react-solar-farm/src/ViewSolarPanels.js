import { useState } from 'react';
import Button from './Button';
import SolarPanelRow from './SolarPanelRow';
import solarPanels from './data.json';

export default function ViewSolarPanels({ toggleView }) {
	const [panels, setPanels] = useState(solarPanels);

	function handleDelete(id) {
		// console.log(id);
		// One approach:
		// const panelsTemp = [];
		// for (const panel of panels) {
		// 	if (panel.id !== id) {
		// 		panelsTemp.push(panel);
		// 	}
		// }
		// Another approach
		// Array.prototype.filter returns a new, filtered array
		// It does not mutate or modify the old array
		// const panelsTemp = panels.filter(p => p.id !== id);
		setPanels(panels.filter(p => p.id !== id));
	}

	return (
		<>
			<h1 className='mb-3'>Solar Panels</h1>
			<Button
				handleClick={() => toggleView('form')}
				classes='mb-3 btn-primary'>
				Add Solar Panel
			</Button>
			{panels.length > 0 ? (
				<table className='table table-striped'>
					<thead>
						<tr>
							<th>Section</th>
							<th>Row</th>
							<th>Column</th>
							<th>Year Installed</th>
							<th>Material</th>
							<th>Tracking Software</th>
							<th>Modify</th>
						</tr>
					</thead>
					<tbody>
						{panels.map(solarPanel => (
							<SolarPanelRow
								solarPanel={solarPanel}
								handleDelete={handleDelete}
								key={solarPanel.id}
							/>
						))}
					</tbody>
				</table>
			) : (
				<div>No panels available to display.</div>
			)}
		</>
	);
}
