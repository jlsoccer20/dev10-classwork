import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import CreateEditAgency from './pages/agencies/CreateEditAgency';
import CreateEditAgent from './pages/agents/CreateEditAgent';
import DeleteAgent from './pages/agents/DeleteAgent';
import Home from './pages/Home';
import NavBar from './components/NavBar';
import NotFound from './pages/NotFound';
import UnexpectedError from './pages/UnexpectedError';
import ViewAgencies from './pages/agencies/ViewAgencies';
import ViewAgents from './pages/agents/ViewAgents';

function App() {
	return (
		<Router>
			<header className='my-3'>
				<NavBar />
			</header>
			<main className='container'>
				<Routes>
					<Route path='/' element={<Home />} />
					{/* Agencies */}
					<Route path='/agencies' element={<ViewAgencies />} />
					<Route
						path='/agencies/add'
						element={<CreateEditAgency />}
					/>
					<Route
						path='/agencies/edit/:agencyId'
						element={<CreateEditAgency />}
					/>

					{/* Agents */}
					<Route path='/agents' element={<ViewAgents />} />
					<Route path='/agents/add' element={<CreateEditAgent />} />
					<Route
						path='/agents/edit/:agentId'
						element={<CreateEditAgent />}
					/>
					<Route
						path='/agents/delete/:agentId'
						element={<DeleteAgent />}
					/>

					{/* Miscellaneous */}
					<Route path='/error' element={<UnexpectedError />} />
					<Route path='*' element={<NotFound />} />
				</Routes>
			</main>
		</Router>
	);
}

export default App;
