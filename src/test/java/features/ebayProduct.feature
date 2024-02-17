Feature: eBay end-to-end test

Scenario: Search for a product and add to cart

Given User is on the eBay "https://www.ebay.com/" page
When User selects the category "Toys & Hobbies" from the drop-down
And User sets value "Monopoly" in the search field 
And User clicks the Search button
Then The first item on the PLP has the title: "Monopoly"
And There is a shipping option to "Bulgaria"
And Price is displayed for the item 
When User clicks on the first item
Then The item title on PDP is matching
And The item price on PDP is matching 
When User scrolls and clicks on Shipping and payments section
Then "Bulgaria" exists in the country drop down list 
When User selects quantity 2
And User clicks Add to cart button
Then User is on the "https://cart.payments.ebay.com/" page
And The expected quantity is displayed in the cart
And The expected calcuated price is displayed in the cart