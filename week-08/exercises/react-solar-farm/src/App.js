import { useState } from 'react';

import Header from './Header';
import SolarPanelForm from './SolarPanelForm';
import ViewSolarPanels from './ViewSolarPanels';

function App() {
	const [view, setView] = useState('list');

	function toggleView(newView) {
		setView(newView);
	}

	function renderView() {
		if (view === 'list') {
			return <ViewSolarPanels toggleView={toggleView} />;
		} else if (view === 'form') {
			return <SolarPanelForm toggleView={toggleView} />;
		}
	}

	return (
		<div className='container'>
			<Header />
			<main>{renderView()}</main>
		</div>
	);
}

export default App;
