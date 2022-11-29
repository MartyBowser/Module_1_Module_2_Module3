module.exports = {
  root: true,
  env: {
    node: true
  },
  'extends': [
    'plugin:vue/essential',
    'eslint:recommended',
    'plugin:import/recommended'
  ],
  parserOptions: {
    parser: 'babel-eslint'
  },
  rules: {
    'import/no-named-as-default-member': 'off',
    'no-console': process.env.NODE_ENV === 'production' ? 'error' : 'off',
    'no-debugger': process.env.NODE_ENV === 'production' ? 'error' : 'off'
  },
  settings: {
    'import/resolver': {
      alias: {
        map: [
          ['@', './src']
        ],
        extensions: [".vue", ".js"]
      }
    },
  }
}
