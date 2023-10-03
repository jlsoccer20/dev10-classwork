# LOTR Character Search 

## Installation 

1. Download code locally. 
1. Navigate a terminal window to the project folder.
1. Run `npm install` to download dependencies.
1. Run `npm start` to start the development server. 

## API Key 

1. Go to [The One API](https://the-one-api.dev/) and sign up for an account to get an API key.
1. Create a file called `.env.local` in the root of the project (at the same level as the `package.json` and `src` folder).
   - For more on custom environment variables in Create React App projects, check out the documentation [here](https://create-react-app.dev/docs/adding-custom-environment-variables/)
1. Add to the `.env.local` file a variable called `REACT_APP_LOTR_API_KEY` and paste your key in.

```
REACT_APP_LOTR_API_KEY=your-api-key
```

### Important!

Restart the development server so that it can read the new value of the environmental variable.
