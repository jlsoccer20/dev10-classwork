import Button from './Button';

export default function SolarPanelRow({ solarPanel, handleDelete }) {
	return (
		<tr>
			<td>{solarPanel.section}</td>
			<td>{solarPanel.row}</td>
			<td>{solarPanel.column}</td>
			<td>{solarPanel.yearInstalled}</td>
			<td>{solarPanel.material}</td>
			<td>{solarPanel.tracking ? 'Yes' : 'No'}</td>
			<td>
				<Button classes='btn-warning me-2'>Edit</Button>
				<Button
					classes='btn-danger'
					handleClick={() => handleDelete(solarPanel.id)}>
					Delete
				</Button>
			</td>
		</tr>
	);
}
