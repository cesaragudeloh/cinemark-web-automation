Feature: Buy a movie ticket online
  As a user
  I want to buy a movie ticket
  For to watch a movie I like


  @BuyTicket
  Scenario: Buy a movie ticket
    Given the user enters at the web site
    When the user purchases a movie ticket
    Then the purchase is successful and the QR code is displayed