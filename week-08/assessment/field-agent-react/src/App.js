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

  // TODO: Implement React Router V6. [DONE]
  const [view, setView] = useState("landing");
  const Component = componentMap[view];

  // TODO: Add routes for update and delete. [DONE]

  // TODO: Add a ConfirmAgentDelete component that renders with the delete route. [DONE]
  // The delete route should contain an agent id. [DONE]
  // Use that id to fetch a single agent, display their name, [DONE]
  // and then either delete or cancel. [DONE]
  // If the agent isn't found. Redirect to the AgentList route. [DONE]

  return (
    <main className="container">
        {/*<Component setView={setView} />*/}
        <Router>
            
            <Nav view={view} setView={setView} />
            <Routes>
                <Route path='/' element={<Landing/>} />
                <Route path='/agents' element={<AgentList/>} />
                <Route path='/agents/add' element={<AgentForm/>} />
                <Route path='/agents/edit/:agentId' element={<AgentForm/>} />
                <Route path='/agents/delete/:agentId' element={<ConfirmAgentDelete setView={setView}/>} />
                <Route path='*' element={"not found"} />
            </Routes>
        </Router>
    </main>
  );
}

export default App;
