import { NavLink } from 'react-router-dom';

import logo from './logo.png';

export default function Header() {
	return (
		<header className='mb-3'>
			<nav className='navbar navbar-expand'>
				<div className='d-flex'>
					<NavLink className='navbar-brand' href='/'>
						<img src={logo} alt='Solar Farm' width='150' />
					</NavLink>
					<ul className='navbar-nav'>
						<li className='nav-item'>
							<NavLink className='nav-link ' href='/'>
								Home
							</NavLink>
						</li>
						<li className='nav-item'>
							<NavLink className='nav-link' href='/'>
								About
							</NavLink>
						</li>
						<li className='nav-item'>
							<NavLink className='nav-link' href='/'>
								Contact
							</NavLink>
						</li>
					</ul>
				</div>
			</nav>
		</header>
	);
}
