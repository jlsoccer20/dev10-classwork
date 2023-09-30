import { useState } from "react";
import { BrowserRouter as Router, Routes, Route} from 'react-router-dom';

import ConfirmAgentDelete from "./components/ConfirmAgentDelete";
import AgentForm from "./components/AgentForm";
import AgentList from "./components/AgentList";
import Landing from "./components/Landing";
import Nav from "./components/Nav";

const componentMap = {
  "form": AgentForm,
  "list": AgentList,
  "landing": Landing
}

function App() {

  // TODO: Implement React Router V6.
  const [view, setView] = useState("landing");
  const Component = componentMap[view];

  // TODO: Add routes for update and delete.

  // TODO: Add a ConfirmAgentDelete component that renders with the delete route.
  // The delete route should contain an agent id. 
  // Use that id to fetch a single agent, display their name, 
  // and then either delete or cancel. 
  // If the agent isn't found. Redirect to the AgentList route.

  return (
    <main className="container">
        {/*<Component setView={setView} />*/}
        <Router>
            
            <Nav view={view} setView={setView} />
            <Routes>
                <Route path='/' element={<Landing/>} />
                <Route path='/agents' element={<AgentList/>} />
                <Route path='/agents/add' element={<AgentForm/>} />
                <Route path='/agents/edit/:id' element={<AgentForm/>} />
                <Route path='/agents/delete/:id' element={<ConfirmAgentDelete/>} />
                <Route path='*' element={"not found"} />
            </Routes>
        </Router>
    </main>
  );
}

export default App;
