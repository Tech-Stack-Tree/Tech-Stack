const capitals = `Pragu ,Czech ,Republic 
Copenhagen, Denmark 
Paris, France 
Madird, Spain 
Rome, Italy`;

capitals.split("\n").forEach((s) => {
  const capital = s.split(",")[0];
  const country = s.split(",")[1];
  console.log(`${capital} is in ${country}`);
});
