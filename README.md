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
curl -X GET "http://localhost:8080/superheroes"

# 2. Get all superheroes (encrypted)
curl -X GET "http://localhost:8080/superheroes?encrypted=true"

# 3. Get superheroes by superpower
curl -X GET "http://localhost:8080/superheroes?superpower=flight"

# 4. Get superheroes by superpower (encrypted)
curl -X GET "http://localhost:8080/superheroes?superpower=flight&encrypted=true"
