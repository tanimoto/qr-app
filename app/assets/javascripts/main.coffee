$ ->
  $text = $("#text")
  $img = $("#qr")

  # Callback: update image
  updateImg = (enc) ->
    $img.attr("src", "data:image/png;base64," + enc)

  # Update on change
  $text.change ->
    text = $text.val()
    $.ajax "/api/qr",
      type: "GET"
      data:
        text: text
      success: (res) ->
        updateImg(res)

  # Trigger a change
  $text.change()
