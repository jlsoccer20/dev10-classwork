import { Link } from "react-router-dom";

//function Nav({ view, setView }) {
function Nav() {
    /*
    function handleAdd() {
        setView("form");
    }

    function handleList(evt) {
        evt.preventDefault();
        setView("list");
    }
    
    {view !== "form" &&
}
    */

    return (
        <div className="d-flex align-items-center">
            <ul className="nav my-4">
                <li className="nav-item">
                    <Link to='/agents' className="nav-link">Agents</Link>
                </li>
                <li className="nav-item">
                    <Link to='/agencies' className="nav-link">Agencies</Link>
                </li>
            </ul>
            
                <div className="d-flex flex-grow-1 justify-content-end">
                    <Link to='/agents/add' className="btn btn-primary">Add Agent</Link>
                </div>
        </div>
    );
}

export default Nav;