import { Link } from 'react-router-dom';
import heroImage from '../images/top-secret.jpg';

function Home() {
	return (
		<div
			className='p-5 mb-4 bg-body-tertiary rounded-3'
			style={{
				background: `url(${heroImage}) no-repeat center center`,
				minHeight: '80vh',
			}}>
			<h1 className='display-5 fw-bold'>Field Agents</h1>

			<Link className='btn btn-dark btn-lg' to='/agents'>
				View Agents
			</Link>
		</div>
	);
}

export default Home;
