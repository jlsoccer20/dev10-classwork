import { useEffect, useState } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import Button from './Button';

export default function ConfirmAgentDelete(){
    const [agent, setAgent] = useState(null);
    const [success, setSuccess] = useState(false);
    const { agentId } = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        if (agentId) {
            fetch('http://localhost:8080/api/agent/' + agentId)
            .then(res => {
                if (res.ok){
                    return res.json();
                } else {
                    return Promise.reject(
                        new Error(`Unexpected status code: ${res.status}`)
                    );
                }
            })
            .then(setAgent)
            .catch(error => {
                console.error(error);
                navigate('/agents');
            });
        }
    }, []);

    function handleDelete() {
        const config = {
            method: 'DELETE',
        };
        
        fetch('http://localhost:8080/api/agent/'+ agentId, config)
            .then(res => {
                if (res.ok){
                    setSuccess(true);
                    setTimeout(() => {
                        navigate('/agents');
                    }, 2000);
                } else {
                    return Promise.reject(
                        new Error(`Unexpected status code ${res.status}`)
                    );
                }
            })
            .catch(error =>{
                console.error(error);
                navigate('/agents');
            });
    }

    if(!agent) {
        return (
            <div
                style={{ minHeight: '80vh' }}
                className='d-flex justify-content-center align-items-center'>
                <div className='spinner-border ' role='status'>
                    <span className='visually-hidden'>Loading...</span>
                </div>
            </div>
        );
    }

    return (
        <div>
            <h1>Delete</h1>
            <div className='alert alert-warning' role='alert'>
                <p>
                    Are you sure you want to delete the following agent?
                </p>
                <ul>
                    <li>
                        Agent name: {agent.firstName}{agent.middleName ? " "  + agent.middleName : ""} {agent.lastName}
                    </li>
                    <li>Agent DOB: {agent.dob}</li>
                    <li>Agent height inches: {agent.heightInInches}</li>
                </ul>
                <Button handleClick={handleDelete} classes='btn-danger me-2'>
                    Delete
                </Button>
                <Link className='btn btn-secondary' to='/agents'>
                    Cancel
                </Link>
            </div>
            {success && (
                <div className='alert alert-successs' role='alert'>
                    <p>
                        Successfully deleted agent! Navigating back to agent list...{' '}
                    </p>
                </div>
            )}
        </div>
    );
}

//export default ConfirmAgentDelete;