# Angular + Spring Boot Dev Tunnel Configuration

## Overview
This project is configured to work with Visual Studio Code Dev Tunnels, allowing you to access both the Angular frontend and Spring Boot backend through secure HTTPS URLs.

## Configuration Summary

### Angular Frontend
- **Port**: 4200
- **Dev Tunnel URL**: https://q08rh8ql-4200.use.devtunnels.ms/
- **Local URL**: http://localhost:4200/

### Spring Boot Backend
- **Port**: 8080
- **Dev Tunnel URL**: https://q08rh8ql-8080.use.devtunnels.ms/
- **Local URL**: http://localhost:8080/

## How It Works

### Proxy Configuration
The Angular application uses a proxy configuration (`proxy.conf.json`) to forward all API requests to the Spring Boot backend. This solves CORS issues and allows seamless communication between frontend and backend.

**proxy.conf.json**:
```json
{
  "/api": {
    "target": "https://q08rh8ql-8080.use.devtunnels.ms",
    "secure": true,
    "changeOrigin": true,
    "logLevel": "debug"
  }
}
```

### Service Updates
All Angular services have been updated to use relative URLs instead of hardcoded `http://localhost:8080`:

- ✅ `paciente.service.ts` → `/api/pacientes`
- ✅ `episodio-clinico.service.ts` → `/api/episodios`
- ✅ `auth.service.ts` → `/api/auth`
- ✅ `solicitud.service.ts` → `/api/solicitudes`
- ✅ `auditoria.service.ts` → `/api/auditoria`

### Angular Configuration
The `angular.json` file has been updated to:
- Use the proxy configuration
- Run on port 4200
- Allow external connections (host: 0.0.0.0)

## Running the Application

### Start Angular (Frontend)
```bash
cd proyecto-bd
npm start
```

### Start Spring Boot (Backend)
Make sure your Spring Boot application is running on port 8080.

## Access URLs

### For Development (Local)
- Frontend: http://localhost:4200/
- Backend: http://localhost:8080/

### For Remote Access (Dev Tunnels)
- Frontend: https://q08rh8ql-4200.use.devtunnels.ms/
- Backend: https://q08rh8ql-8080.use.devtunnels.ms/

## How API Calls Work

When your Angular app makes a request to `/api/pacientes`, the proxy:
1. Intercepts the request
2. Forwards it to `https://q08rh8ql-8080.use.devtunnels.ms/api/pacientes`
3. Returns the response to the Angular app

This works both locally and through the dev tunnel!

## Troubleshooting

### If the proxy isn't working:
1. Check that the Spring Boot backend is running on port 8080
2. Verify the dev tunnel URL is correct
3. Check the browser console for proxy errors
4. Look at the Angular dev server logs for proxy debug messages

### If you need to update the dev tunnel URL:
1. Update `proxy.conf.json` with the new backend URL
2. Restart the Angular dev server (`npm start`)

## Notes
- The proxy only works in development mode
- For production builds, you'll need to configure CORS on the Spring Boot backend
- Make sure both dev tunnels (4200 and 8080) are active in VS Code
