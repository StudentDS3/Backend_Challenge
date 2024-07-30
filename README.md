# Steps to Follow

# Build the Docker Image:
docker build -t superhero-app .

# Run the Docker Container:
docker run -p 8080:8080 superhero-app

# Access the API:
# Open http://localhost:8080/ in your browser
# or use curl to get different use cases:

# Example curl requests:
# 1. Get all superheroes
curl http://localhost:8080/api/superheroes

# 2. Get all superheroes (encrypted)
curl http://localhost:8080/api/superheroes/encrypted

# 3. Get superheroes by superpower
curl http://localhost:8080/api/superheroes/superpower/flight

# 4. Get superheroes by superpower (encrypted)
curl http://localhost:8080/api/superheroes/superpower/encrypted/flight
