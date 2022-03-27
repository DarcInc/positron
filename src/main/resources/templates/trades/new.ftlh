<!doctype html>
<html>
<head>
    <title>Enter Trade</title>
</head>
<body>
<h1>Enter Trade</h1>
<form action="/trades" method="post">
    <div>
        <label for="ticker">Ticker</label>
        <input type="text" name="ticker" id="ticker">
    </div>
    <div>
        <label for="transType">Transaction</label>
        <select name="transType" id="transType">
            <option value="buy">Buy</option>
            <option value="sell">Sell</option>
        </select>
    </div>
    <div>
        <label for="eventDate">Event Date</label>
        <input type="date" name="eventDate" id="eventDate">
    </div>
    <div>
        <label for="units">Units</label>
        <input type="number" min="0" max="1000000" step="1" name="units" id="units">
    </div>
    <div>
        <label id="price">Price</label>
        <input type="number" min="0" step="0.01" name="price" id="price">
    </div>
    <div>
        <input type="submit" value="Save">
    </div>
</form>
</body>
</html>