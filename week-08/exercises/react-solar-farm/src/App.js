import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import About from "./About";
import Contact from "./Contact";
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
        <Router>
            <Header />
            <main>
                <Routes>
                    <Route path='/' element={<ViewSolarPanels />} />
                    <Route path='/add' element={SolarPanelForm />}/>
                
                </Routes>
            </main>
        </Router>
	);
}

export default App;
