import { Link, useLocation } from 'react-router-dom';

function UnexpectedError() {
	const location = useLocation();
	const errorDetail = location.state?.error?.message;

	return (
		<section className='alert alert-danger' role='alert'>
			<h1>Error</h1>
			<p>
				{errorDetail ??
					'An unexpected error occurred. Please try again later.'}
			</p>
			<Link to='/'>Return home.</Link>
		</section>
	);
}

export default UnexpectedError;
